package com.learnprojects.example.Repositories;

import com.learnprojects.example.Domain.Member;

import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepo implements MemberRepo {

    private final DataSource dataSource;

    public JdbcMemberRepo(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    private Connection getConnection(){
        return DdatasourceUtils.getConnection(dataSource);
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)";

        Connection connection = null;
        PreparedStatement pre;
        ResultSet rs = null;

        try {
            connection = getConnection();
            pre = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pre.setString(1, member.getName());
            pre.executeUpdate();
            rs = pre.getGeneratedKeys();

            if (rs.next()) {
                member.setId(rs.getLong(1));
            } else {
                throw new SQLException("id fail");
            }
            return member;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(connection, pre, rs);
        }


        return null;
    }

    private void close(Connection conn, PreparedStatement pstmt,ResultSet set){
        try{
            if(set != null){
                set.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(pstmt != null){
                pstmt.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
