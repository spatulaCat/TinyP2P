/*
 * The MIT License
 *
 * Copyright 2015 Nicky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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



/**
 *
 * @author Nicky
 */
public class setupConnection {
    
    public IH2HNode node;
    private final BigInteger maxFileSize = H2HConstants.DEFAULT_MAX_FILE_SIZE;
    private final int maxNumOfVersions = H2HConstants.DEFAULT_MAX_NUM_OF_VERSIONS;
    private final BigInteger maxSizeAllVersions = H2HConstants.DEFAULT_MAX_SIZE_OF_ALL_VERSIONS;
    private final int chunkSize = H2HConstants.DEFAULT_CHUNK_SIZE;
    private  IFileConfiguration fileConfiguration;
    
    protected final Config config;
    
    public setupConnection(){
        this.config = ConfigFactory.load("client.conf");
  
    }
       
//    public setupConnection(IH2HNode n){
//        this.config = ConfigFactory.load("client.conf");
//        this.node = n;
  //  }
    
     public void connectNode(NetworkConfiguration networkConfig) {
        if (node.connect(networkConfig)) {
            node.getFileManager().subscribeFileEvents(new FileEventListener(node.getFileManager()));
            
            if ( config.getBoolean("Relay.enabled")) {
                String authenticationKey = config.getString("Relay.GCM.api-key");
                long bufferAge = config.getDuration("Relay.GCM.buffer-age-limit", TimeUnit.MILLISECONDS);
                
                MessageBufferConfiguration bufferConfiguration = new MessageBufferConfiguration().bufferAgeLimit(bufferAge);
                AndroidRelayServerConfig androidServer = new AndroidRelayServerConfig(authenticationKey, 5,
                        bufferConfiguration);
                BufferedTCPRelayServerConfig tcpServer = new BufferedTCPRelayServerConfig(bufferConfiguration);
                
                new PeerBuilderNAT(node.getPeer().peer()).addRelayServerConfiguration(RelayType.ANDROID, androidServer)
                        .addRelayServerConfiguration(RelayType.BUFFERED_OPENTCP, tcpServer).start();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Network connection could not be established.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }
     
   public void shutdown() {
        if (node != null && node.isConnected()) {
            node.disconnect();
        }
    }
    
     
      public void buildNode() {
        IFileConfiguration fileConfig = FileConfiguration.createCustom(maxFileSize, maxNumOfVersions, maxSizeAllVersions,
                chunkSize);
        IH2HSerialize serializer;  
        if ("java".equalsIgnoreCase(config.getString("Serializer.mode"))) {
           serializer = new JavaSerializer();
        } else {
            serializer = new FSTSerializer(config.getBoolean("Serializer.FST.unsafe"), new BCSecurityClassProvider());
        }
        fileConfiguration = fileConfig;
        node = H2HNode.createNode(fileConfig, new H2HDefaultEncryption(serializer), serializer);
        
    }
    
    
}
