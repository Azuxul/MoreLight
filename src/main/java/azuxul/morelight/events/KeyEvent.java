package azuxul.morelight.events;

import azuxul.morelight.MoreLight;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;

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
