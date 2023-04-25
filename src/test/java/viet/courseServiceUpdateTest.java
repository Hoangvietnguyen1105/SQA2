package viet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.viet.dto.courseDTO;
import com.viet.entity.courseEntity;
import com.viet.converter.courseConverter;
import com.viet.repository.courseRepository;
import com.viet.services.IcourseService;
import com.viet.services.impl.courseService;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class courseServiceUpdateTest {
    @Mock
    private courseRepository cR;
    
    @Mock
    private courseConverter cC;
    
    @InjectMocks
    private courseService courseService ;
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void testUpdateWithDuplicateCoursesCode() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        int id = 123;
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setId(id);
        coursedto.setName(name);
        courseEntity cE1 = new courseEntity();
        cE1.setCoursesCode(coursesCode);
        cE1.setId(122);
        cE1.setName("nam");
        when(cR.findOneByNameAndIdNot(name,id)).thenReturn(null);
        when(cR.findOneBycoursesCodeAndIdNot(coursedto.getCoursesCode(),coursedto.getId())).thenReturn(cE1);

        // When
        String result = courseService.update(coursedto);

        // Then
        assertEquals("Duplicate", result);
        verify(cR, times(1)).findOneBycoursesCodeAndIdNot(coursesCode,id);
        verify(cR, times(1)).findOneByNameAndIdNot(name,id);
        verify(cR, never()).save(any(courseEntity.class));
    }
    @Test
    public void testUpdateWithDuplicateName() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        int id = 123;
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setId(id);
        coursedto.setName(name);
        courseEntity cE1 = new courseEntity();
        cE1.setCoursesCode(coursesCode);
        cE1.setId(122);
        cE1.setName(name);
        when(cR.findOneByNameAndIdNot(name,id)).thenReturn(cE1);
        when(cR.findOneBycoursesCodeAndIdNot(coursedto.getCoursesCode(),coursedto.getId())).thenReturn(null);

        // When
        String result = courseService.update(coursedto);

        // Then
        assertEquals("Duplicate", result);
        verify(cR, times(1)).findOneBycoursesCodeAndIdNot(coursesCode,id);
        verify(cR, times(1)).findOneByNameAndIdNot(name,id);
        verify(cR, never()).save(any(courseEntity.class));
    }
    @Test
    public void testUpdateWithDuplicateNameAndCourseCode() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        int id = 123;
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setId(id);
        coursedto.setName(name);
        courseEntity cE1 = new courseEntity();
        cE1.setCoursesCode(coursesCode);
        cE1.setId(122);
        cE1.setName(name);
        when(cR.findOneByNameAndIdNot(name,id)).thenReturn(cE1);
        when(cR.findOneBycoursesCodeAndIdNot(coursedto.getCoursesCode(),coursedto.getId())).thenReturn(cE1);

        // When
        String result = courseService.update(coursedto);

        // Then
        assertEquals("Duplicate", result);
        verify(cR, times(1)).findOneBycoursesCodeAndIdNot(coursesCode,id);
        verify(cR, times(1)).findOneByNameAndIdNot(name,id);
        verify(cR, never()).save(any(courseEntity.class));
    }
    @Test
    public void testUpdateWithSuccess() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        int id = 123;
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setId(id);
        coursedto.setName(name);
        courseEntity cE1 = new courseEntity();
        cE1.setCoursesCode("sdfsdf");
        cE1.setId(122);
        cE1.setName("sdfsdf");
        when(cR.findOneByNameAndIdNot(name,id)).thenReturn(null);
        when(cR.findOneBycoursesCodeAndIdNot(coursedto.getCoursesCode(),coursedto.getId())).thenReturn(null);

        // When
        String result = courseService.update(coursedto);

        // Then
        assertEquals("Success", result);
        verify(cR, times(1)).findOneBycoursesCodeAndIdNot(coursesCode,id);
        verify(cR, times(1)).findOneByNameAndIdNot(name,id);
        verify(cR, never()).save(any(courseEntity.class));
    }
    
    
    

}
