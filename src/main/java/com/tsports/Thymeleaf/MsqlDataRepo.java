package com.tsports.Thymeleaf;

import java.util.List;

public interface MsqlDataRepo {
    public List<TransactionsData> getMsqlData(String emailOrPhone) throws Exception;
}
