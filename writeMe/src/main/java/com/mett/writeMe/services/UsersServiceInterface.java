package com.mett.writeMe.services;

import java.util.List;

<<<<<<< HEAD
import com.mett.writeMe.pojo.UserPOJO;
import com.mett.writeMe.contracts.UsersRequest;
=======
import com.mett.writeMe.contracts.UsersRequest;
import com.mett.writeMe.pojo.UserPOJO;
>>>>>>> 5ea676e617fc95993412b4f433b21c4e1771e80d

public interface UsersServiceInterface {

	List<UserPOJO> getAll(UsersRequest ur);
	List<UserPOJO> getAllByName(UsersRequest ur);
	Boolean saveUser(UsersRequest ur);
}
