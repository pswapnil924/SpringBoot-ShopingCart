package com.tudip.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "buyer")
public class Buyer extends User{

    private String userAddress;
    private String userPinCode;
    @Column(columnDefinition = "boolean default false")
    private boolean isUserBlocked;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPinCode() {
        return userPinCode;
    }

    public void setUserPinCode(String userPinCode) {
        this.userPinCode = userPinCode;
    }

    public boolean isUserBlocked() {
        return isUserBlocked;
    }

    public void setUserBlocked(boolean userBlocked) {
        isUserBlocked = userBlocked;
    }
}
