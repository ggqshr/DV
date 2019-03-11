package ggq.mapper;

import ggq.model.UserTable;

public interface UserTableMapper {
    UserTable getUserByUserName(String userName);
}
