package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorObjectAdapter implements Door {

    ThirdPartyDoor thirdPartyDoor;
    public ThirdPartyDoorObjectAdapter(){
        this.thirdPartyDoor = new ThirdPartyDoor();
    }
    @Override
    public void open(String code) throws IncorrectDoorCodeException {
        try {
            this.thirdPartyDoor.unlock(code);
            this.thirdPartyDoor.setState(ThirdPartyDoor.DoorState.OPEN);
        } catch (CannotUnlockDoorException | CannotChangeStateOfLockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }
    }

    @Override
    public void close() {
        try {
            this.thirdPartyDoor.setState(ThirdPartyDoor.DoorState.CLOSED);
            this.thirdPartyDoor.lock();
        } catch (CannotChangeStateOfLockedDoor e) {}
    }

    @Override
    public boolean isOpen() {
        return this.thirdPartyDoor.getState() == ThirdPartyDoor.DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException {
        try {
            this.thirdPartyDoor.unlock(oldCode);
            if(!newCode.equals(newCodeConfirmation)) {
                throw new CodeMismatchException();
            }
            this.thirdPartyDoor.setNewLockCode(newCode);
        } catch (CannotUnlockDoorException | CannotChangeCodeForUnlockedDoor e) {
            throw new IncorrectDoorCodeException(e);
        }


    }

    @Override
    public boolean testCode(String code) {
        boolean testResult = false;
        try {
            this.thirdPartyDoor.unlock(code);
            if (this.thirdPartyDoor.getLockStatus().equals(ThirdPartyDoor.LockStatus.UNLOCKED)) {
                testResult = true;
            }
        } catch (CannotUnlockDoorException e) {}
        return testResult;
    }
}
