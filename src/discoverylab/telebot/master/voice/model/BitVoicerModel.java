package discoverylab.telebot.master.voice.model;

public class BitVoicerModel {

	private String voiceCommand;
	
	public BitVoicerModel(){}
	public BitVoicerModel(String voiceCommand){
		this.voiceCommand = voiceCommand;
	}
	
	public String getVoiceCommand() {
		return voiceCommand;
	}
	public void setVoiceCommand(String voiceCommand) {
		this.voiceCommand = voiceCommand;
	}
}
