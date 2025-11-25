package com.mycompany.smsnetbeans;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CourseDAO {

    // Insert course into database
    public static boolean saveCourse(Course course) {
        String sql = "INSERT INTO courses (id, name, credits) VALUES (?, ?, ?)";
        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

        //    ps.setString(1, course.getId());         Course ID
            ps.setString(2, course.getName());      // Course Name
            ps.setInt(3, course.getCredits());      // Course Credits

            ps.executeUpdate();
            return true; // Success
        } catch (Exception e) {
            e.printStackTrace();
            return false; // Failure
        }
    }
}
