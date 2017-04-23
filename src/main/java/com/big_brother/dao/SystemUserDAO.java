package com.big_brother.dao;

import com.big_brother.models.SystemUser;

/**
 * Created by denysburlakov on 23.04.17.
 */

public interface SystemUserDAO{
    SystemUser getSystemUserByLogin(String login);
}
