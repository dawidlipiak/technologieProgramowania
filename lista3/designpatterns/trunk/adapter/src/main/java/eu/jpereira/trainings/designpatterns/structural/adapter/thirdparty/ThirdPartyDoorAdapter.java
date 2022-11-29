package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door {

    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            super.unlock(code);
            super.setState(DoorState.OPEN);
        } catch(CannotUnlockDoorException | CannotChangeStateOfLockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }
    }

    @Override
    public void close() {
        try {
            super.setState(DoorState.CLOSED);
            super.lock();
        } catch (CannotChangeStateOfLockedDoor cannotChangeStateOfLockedDoor) {
            // ignore
        }
    }

    @Override
    public boolean isOpen() {
        return super.getState() == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        try {
            super.unlock(oldCode);
            if(!newCode.equals(newCodeConfirmation)) throw new CodeMismatchException();
            super.setNewLockCode(newCode);
        } catch (CannotUnlockDoorException | CannotChangeCodeForUnlockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }
    }

    @Override
    public boolean testCode(String code) {
        boolean result = false;
        try {
            super.unlock(code);
            result = super.getLockStatus() == LockStatus.UNLOCKED;
            super.lock();
        } catch (CannotUnlockDoorException e) {
        }
        return result;
    }
}
