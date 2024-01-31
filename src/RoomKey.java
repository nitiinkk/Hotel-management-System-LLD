import java.time.LocalDate;
import java.util.UUID;

public class RoomKey {
    UUID keyId;
    LocalDate issuedAt;
    boolean active;
    boolean isMaster;

    RoomKey() {
       this.keyId = UUID.randomUUID();
       this.active = true;
    }

    public UUID assignRoom() {
        this.issuedAt = LocalDate.now();
        this.isMaster = true;
        return keyId;
    }

    public void setActive() {
        this.active = true;
    }

    public void setInActive() {
        this.active = false;
    }

    public void setMaster() {
        this.isMaster = true;
    }

    public void unsetMaster() {
        this.isMaster = false;
    }

}
