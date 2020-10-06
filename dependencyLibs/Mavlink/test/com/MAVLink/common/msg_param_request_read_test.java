/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */
         
// MESSAGE PARAM_REQUEST_READ PACKING
package com.MAVLink.common;
import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Parser;
import com.MAVLink.ardupilotmega.CRC;
import java.nio.ByteBuffer;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
* Request to read the onboard parameter with the param_id string id. Onboard parameters are stored as key[const char*] -> value[float]. This allows to send a parameter to any other component (such as the GCS) without the need of previous knowledge of possible parameter names. Thus the same GCS can store different parameters for different autopilots. See also http://qgroundcontrol.org/parameter_interface for a full documentation of QGroundControl and IMU code.
*/
public class msg_param_request_read_test{

public static final int MAVLINK_MSG_ID_PARAM_REQUEST_READ = 20;
public static final int MAVLINK_MSG_LENGTH = 20;
private static final long serialVersionUID = MAVLINK_MSG_ID_PARAM_REQUEST_READ;

private Parser parser = new Parser();

public CRC generateCRC(byte[] packet){
    CRC crc = new CRC();
    for (int i = 1; i < packet.length - 2; i++) {
        crc.update_checksum(packet[i] & 0xFF);
    }
    crc.finish_checksum(MAVLINK_MSG_ID_PARAM_REQUEST_READ);
    return crc;
}

public byte[] generateTestPacket(){
    ByteBuffer payload = ByteBuffer.allocate(6 + MAVLINK_MSG_LENGTH + 2);
    payload.put((byte)MAVLinkPacket.MAVLINK_STX); //stx
    payload.put((byte)MAVLINK_MSG_LENGTH); //len
    payload.put((byte)0); //seq
    payload.put((byte)255); //sysid
    payload.put((byte)190); //comp id
    payload.put((byte)MAVLINK_MSG_ID_PARAM_REQUEST_READ); //msg id
    payload.putShort((short)17235); //param_index
    payload.put((byte)139); //target_system
    payload.put((byte)206); //target_component
    //param_id
    payload.put((byte)'E');
    payload.put((byte)'F');
    payload.put((byte)'G');
    payload.put((byte)'H');
    payload.put((byte)'I');
    payload.put((byte)'J');
    payload.put((byte)'K');
    payload.put((byte)'L');
    payload.put((byte)'M');
    payload.put((byte)'N');
    payload.put((byte)'O');
    payload.put((byte)'P');
    payload.put((byte)'Q');
    payload.put((byte)'R');
    payload.put((byte)'S');
    payload.put((byte)'E');
    
    CRC crc = generateCRC(payload.array());
    payload.put((byte)crc.getLSB());
    payload.put((byte)crc.getMSB());
    return payload.array();
}

@Test
public void test(){
    byte[] packet = generateTestPacket();
    for(int i = 0; i < packet.length - 1; i++){
        parser.mavlink_parse_char(packet[i] & 0xFF);
    }
    MAVLinkPacket m = parser.mavlink_parse_char(packet[packet.length - 1] & 0xFF);
    byte[] processedPacket = m.encodePacket();
    assertArrayEquals("msg_param_request_read", processedPacket, packet);
}
}
        