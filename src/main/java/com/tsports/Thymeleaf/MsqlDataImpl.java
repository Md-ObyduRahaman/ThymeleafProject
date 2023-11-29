package com.tsports.Thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsqlDataImpl implements  MsqlDataRepo{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<TransactionsData> getMsqlData(String emailOrPhone) {

        String sql="SELECT tran_status,tran_gw,transaction_id,amount,tran_date,card_type,reg_type,username,subscriber_id,device_type,id FROM transactions\n" +
                "WHERE username = '"+emailOrPhone+"' ORDER BY id desc;";
        List<TransactionsData> transactionsData=null;

        try {

            transactionsData = jdbcTemplate.query(sql,
                    BeanPropertyRowMapper.newInstance(TransactionsData.class));
        }catch (Exception e){
            e.printStackTrace();
        }

        return transactionsData;
    }
}
