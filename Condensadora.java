package arCondicionadoSplit;

import java.awt.Toolkit;

import arCondicionadoSplit.util.SwitchStatus;

public class Condensadora {

	private SwitchStatus switched;

	// Método usado para comutar a Condensadora
	public void setSwitched() {
		if(this.switched == SwitchStatus.ON) {
			turnCompressorOff();
			this.switched = SwitchStatus.OFF;
			
		}else {
			turnCompressorOn();
			this.switched = SwitchStatus.ON;
		}
	}
	
	public void turnCompressorOn() {
		Toolkit.getDefaultToolkit().beep();
		//System.out.println("Compressor ligado");
		// aciona o compressor
	}
	public void turnCompressorOff() {
		Toolkit.getDefaultToolkit().beep();
		//System.out.println("Compressor desligado");
		// desliga o compressor
	}
 
}
