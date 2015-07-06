package discoverylab.telebot.master.voice;

import static discoverylab.util.logging.LogUtils.*;

import com.rti.dds.infrastructure.InstanceHandle_t;

import TelebotDDSCore.DDSCommunicator;
import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoice;
import TelebotDDSCore.Source.Java.Generated.master.voice.TMasterToSlaveVoiceDataWriter;
import discoverylab.telebot.master.core.component.CoreMasterTCPComponent;
import discoverylab.telebot.master.core.socket.CoreServerSocket;
import discoverylab.telebot.master.voice.model.BitVoicerModel;
import discoverylab.telebot.master.voice.parser.BitVoicerParser;

public class TelebotMasterVoiceControlTCP extends CoreMasterTCPComponent implements CoreServerSocket.CallbackInterface{

	public static String TAG = makeLogTag("TelebotMasterVoiceControlTCP");
	private CallbackInterface callbackInterface;
	private BitVoicerParser parser;
	private DDSCommunicator communicator;
	
	private TMasterToSlaveVoiceDataWriter writer;
	TMasterToSlaveVoice instance = new TMasterToSlaveVoice();
	InstanceHandle_t instance_handle = InstanceHandle_t.HANDLE_NIL;
	
	public TelebotMasterVoiceControlTCP(int portNumber) {
		super(portNumber);
		
		parser = new BitVoicerParser();
	}
	
	/**
	 * Cast the Writer to our Arms DataWriter
	 * This allows us to publish the appropriate Topic data
	 */
	public void initiateDataWriter(){
		writer = (TMasterToSlaveVoiceDataWriter) getDataWriter();
	}

	@Override
	public void callback(String data) {
		BitVoicerModel bitVoicerInstance = (BitVoicerModel) parser.parse(data);
		
		LOGI(TAG, "Data: " + data);
		
		callbackInterface.callback(bitVoicerInstance);
		
		instance.voiceCommand = bitVoicerInstance.getVoiceCommand();
		writer.write(instance, instance_handle);
	}

	/**
	 * CallbackInterface
	 * @author Irvin Steve Cardenas
	 * 
	 * Callback interface to retrieve parsed Data Object
	 * Purpose: GUI or other components can implement this to receive a  YEIDataModel object object
	 *
	 */
	public interface CallbackInterface{
		public void callback(BitVoicerModel bitVoicerInstance);
	}
}
