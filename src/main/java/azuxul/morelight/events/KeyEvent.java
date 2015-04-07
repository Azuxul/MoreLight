package azuxul.morelight.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import azuxul.morelight.MoreLight;

public class KeyEvent {

	 @SubscribeEvent
	 public void onKeyInput(InputEvent.KeyInputEvent event) {
		 
		 if(MoreLight.ActiveNightVision.isPressed()){
			 
			 if(MoreLight.NightVision == false){
				 
				 MoreLight.NightVision = true;
			 }
			 else{
				 
				 MoreLight.ResetNightVision = true;
				 MoreLight.NightVision = false;
			 }
		 }
		 
	 }
}
