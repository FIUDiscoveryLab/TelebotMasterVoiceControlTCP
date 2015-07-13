package discoverylab.telebot.master.voice.test;

import static discoverylab.util.logging.LogUtils.*;
import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoice;
import TelebotDDSCore.Source.Java.Generated.master.voice.TOPIC_MASTER_TO_SLAVE_VOICE;
import discoverylab.telebot.master.core.socket.CoreServerSocket.SocketEventListener;
import discoverylab.telebot.master.voice.TelebotMasterVoiceControlTCP;
import discoverylab.telebot.master.voice.TelebotMasterVoiceControlTCP.CallbackInterface;
import discoverylab.telebot.master.voice.model.BitVoicerModel;

/**
 * TelebotMasterVoiceControlTCPTest
 * @author Irvin Steve Cardenas
 * 
 * Driver Class for testing TelebotMasterVoiceControlTCPTest
 */
public class TelebotMasterVoiceControlTCPTest /*implements CallbackInterface*/ {
	
	public static String TAG = makeLogTag("TelebotMasterVoiceControlTCPTest");
	
	public static void main(String args[]){
		
		// 1. INITIATE Master Component
		TelebotMasterVoiceControlTCP telebotMasterVoice = new TelebotMasterVoiceControlTCP(5010);
		telebotMasterVoice.initiate();
		
		// 2. INITIATE Transmission PROTOCOL
		telebotMasterVoice.initiateTransmissionProtocol(
				TOPIC_MASTER_TO_SLAVE_VOICE.VALUE, TMasterToSlaveVoice.class);
		
		// 3, INITIATE DataWriter
		telebotMasterVoice.initiateDataWriter();
	}

//	@Override
//	public void callback(BitVoicerModel bitVoicerInstance) {
//		System.out.println("GUI::: " + bitVoicerInstance.getVoiceCommand());
//	}
}
