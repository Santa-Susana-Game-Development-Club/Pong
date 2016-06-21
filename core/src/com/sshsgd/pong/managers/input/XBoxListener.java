package com.sshsgd.pong.managers.input;

import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.controllers.ControllerAdapter;
import com.badlogic.gdx.controllers.PovDirection;

public class XBoxListener extends ControllerAdapter {

	@Override
	public boolean buttonDown(Controller controller, int buttonIndex) {
		if(buttonIndex == XBoxMappings.START) {
			MyInput.setKey(MyInput.START, true);
		}
		if(buttonIndex == XBoxMappings.BACK) {
			MyInput.setKey(MyInput.BACK, true);
		}
		return true;
	}

	@Override
	public boolean buttonUp(Controller controller, int buttonIndex) {
		if(buttonIndex == XBoxMappings.START) {
			MyInput.setKey(MyInput.START, false);
		}
		if(buttonIndex == XBoxMappings.BACK) {
			MyInput.setKey(MyInput.BACK, false);
		}
		return true;
	}

	@Override
	public boolean axisMoved(Controller controller, int axisIndex, float value) {
		if(axisIndex == XBoxMappings.LEFT_Y_AXIS) {
			if(value < -.3f) {
				MyInput.setKey(MyInput.UP, true);
			} else {
				MyInput.setKey(MyInput.UP, false);
			}
			if(value > .3f) {
				MyInput.setKey(MyInput.DOWN, true);
			} else {
				MyInput.setKey(MyInput.DOWN, false);
			}
		}
		return true;
	}

	@Override
	public boolean povMoved(Controller controller, int povIndex, PovDirection value) {
		if(value == PovDirection.north || value == PovDirection.northEast || value == PovDirection.northWest) {
			MyInput.setKey(MyInput.UP, true);
		} else {
			MyInput.setKey(MyInput.UP, false);
		}
		if(value == PovDirection.south || value == PovDirection.southEast || value == PovDirection.southWest) {
			MyInput.setKey(MyInput.UP, true);
		} else {
			MyInput.setKey(MyInput.UP, false);
		}
		return true;
	}

}
