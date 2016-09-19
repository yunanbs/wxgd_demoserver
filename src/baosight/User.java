package baosight;

import java.io.Serializable;

/**
 * Created by YuNan on 2016/9/19.
 */
public class User implements Serializable {
    public String userId;
    public String orgId;


    public User(){

    }

    public User(String uid,String oid){
        userId = uid;
        orgId = oid;
    }
}
