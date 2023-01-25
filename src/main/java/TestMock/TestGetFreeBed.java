package TestMock;

import Hospital.Bed;
import Hospital.Department;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import Hospital.Room;
import org.junit.Test;

import java.util.ArrayList;

public class TestGetFreeBed {
    @Test
    public void Room(){
        Room room = mock(Room.class);
        when(room.getBeds().iterator());
    }
    @Test
    public void Department(){
        Department department = mock(Department.class);
        when(department.getRooms().iterator());
    }

}
