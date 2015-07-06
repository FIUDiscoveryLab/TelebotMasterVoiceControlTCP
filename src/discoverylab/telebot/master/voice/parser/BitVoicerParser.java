package discoverylab.telebot.master.voice.parser;

import discoverylab.telebot.master.core.parser.CoreDataParser;
import discoverylab.telebot.master.voice.model.BitVoicerModel;

public class BitVoicerParser extends CoreDataParser{

	@Override
	public Object parse(String str) {
		return new BitVoicerModel(str.trim());
	}

}
