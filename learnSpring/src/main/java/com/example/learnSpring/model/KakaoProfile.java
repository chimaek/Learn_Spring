package com.example.learnSpring.model;
public class KakaoProfile {

class KakaoAccount {

    public Boolean profileNicknameNeedsAgreement;
    public Boolean profileImageNeedsAgreement;
    public KakaoProfile.Profile profile;
    public Boolean hasEmail;
    public Boolean emailNeedsAgreement;
    public Boolean isEmailValid;
    public Boolean isEmailVerified;
    public String email;

}




    public Integer id;
    public String connectedAt;
    public Properties properties;
    public KakaoAccount kakaoAccount;


    class Profile {

        public String nickname;
        public String thumbnailImageUrl;
        public String profileImageUrl;
        public Boolean isDefaultImage;

    }

    class Properties {

        public String nickname;

    }
}
