
package tinyp2p;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import net.tomp2p.nat.PeerBuilderNAT;
import net.tomp2p.relay.RelayType;
import net.tomp2p.relay.android.AndroidRelayServerConfig;
import net.tomp2p.relay.buffer.MessageBufferConfiguration;
import net.tomp2p.relay.tcp.buffered.BufferedTCPRelayServerConfig;
import util.FileEventListener;
import org.hive2hive.core.H2HConstants;
import org.hive2hive.core.api.H2HNode;
import org.hive2hive.core.api.configs.FileConfiguration;
import org.hive2hive.core.api.configs.NetworkConfiguration;
import org.hive2hive.core.api.interfaces.IFileConfiguration;
import org.hive2hive.core.api.interfaces.IH2HNode;
import org.hive2hive.core.security.BCSecurityClassProvider;
import org.hive2hive.core.security.H2HDefaultEncryption;
import org.hive2hive.core.serializer.FSTSerializer;
import org.hive2hive.core.serializer.IH2HSerialize;
import org.hive2hive.core.serializer.JavaSerializer;


public class setupConnection {
    
    public IH2HNode node;
    private final BigInteger maxFileSize = H2HConstants.DEFAULT_MAX_FILE_SIZE;
    private final int maxNumOfVersions = H2HConstants.DEFAULT_MAX_NUM_OF_VERSIONS;
    private final BigInteger maxSizeAllVersions = H2HConstants.DEFAULT_MAX_SIZE_OF_ALL_VERSIONS;
    private final int chunkSize = H2HConstants.DEFAULT_CHUNK_SIZE;
    private  IFileConfiguration fileConfig;
    
    protected final Config config;
    
    public setupConnection(){
        this.config = ConfigFactory.load("client.conf");
    }
    
     public boolean connectNode(NetworkConfiguration networkConfig) {
        if (node.connect(networkConfig)) {
            node.getFileManager().subscribeFileEvents(new FileEventListener(node.getFileManager()));
            
            if (config.getBoolean("Relay.enabled")) {
                String authenticationKey = config.getString("Relay.GCM.api-key");
                long bufferAge = config.getDuration("Relay.GCM.buffer-age-limit", TimeUnit.MILLISECONDS);
                
                MessageBufferConfiguration bufferConfiguration = new MessageBufferConfiguration().bufferAgeLimit(bufferAge);
                AndroidRelayServerConfig androidServer = new AndroidRelayServerConfig(authenticationKey, 5,
                        bufferConfiguration);
                BufferedTCPRelayServerConfig tcpServer = new BufferedTCPRelayServerConfig(bufferConfiguration);
                
                new PeerBuilderNAT(node.getPeer().peer()).addRelayServerConfiguration(RelayType.ANDROID, androidServer)
                        .addRelayServerConfiguration(RelayType.BUFFERED_OPENTCP, tcpServer).start();
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Network connection could not be established. \n1. Ensure that Mnemonic or IP address is correct\n2. Check your connection", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
    }
    
      public void buildNode() {
        fileConfig = FileConfiguration.createCustom(maxFileSize, maxNumOfVersions, maxSizeAllVersions,
                chunkSize);
        IH2HSerialize serializer;  
        if ("java".equalsIgnoreCase(config.getString("Serializer.mode"))) {
           serializer = new JavaSerializer();
        } else {
            serializer = new FSTSerializer(config.getBoolean("Serializer.FST.unsafe"), new BCSecurityClassProvider());
        }
        node = H2HNode.createNode(fileConfig, new H2HDefaultEncryption(serializer), serializer);
    }
}
