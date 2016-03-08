package com.mett.writeMe.services;

import java.util.List;

import com.mett.writeMe.contracts.MyLibraryRequest;
import com.mett.writeMe.pojo.MyLibraryPOJO;

public interface MyLibraryServiceInterface {
	
	List<MyLibraryPOJO> getAll(MyLibraryRequest ur);
	List<MyLibraryPOJO> getAllByTitle(MyLibraryRequest ur);
	Boolean saveLibrary(MyLibraryRequest ur);
}
