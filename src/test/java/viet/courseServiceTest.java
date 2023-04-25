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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class courseServiceTest {

    @Mock
    private courseRepository cR;

    @Mock
    private courseConverter cC;

    @InjectMocks
    private courseService courseService;

    @Test
    public void testSaveWithDuplicateCoursesCode() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setName(name);
        courseEntity cE1 = new courseEntity();
        cE1.setCoursesCode("abc");

        when(cR.findOneBycoursesCode(coursesCode)).thenReturn(cE1);
        when(cR.findOneByName(name)).thenReturn(null);

        // When
        String result = courseService.save(coursedto);

        // Then
        assertEquals("Duplicate", result);
        verify(cR, times(1)).findOneBycoursesCode(coursesCode);
        verify(cR, times(1)).findOneByName(name);
        verify(cR, never()).save(any(courseEntity.class));
    }

    @Test
    public void testSaveWithDuplicateName() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setName(name);
        courseEntity cE2 = new courseEntity();
        cE2.setName(name);

        when(cR.findOneBycoursesCode(coursesCode)).thenReturn(null);
        when(cR.findOneByName(name)).thenReturn(cE2);

        // When
        String result = courseService.save(coursedto);

        // Then
        assertEquals("Duplicate", result);
        verify(cR, times(1)).findOneBycoursesCode(coursesCode);
        verify(cR, times(1)).findOneByName(name);
        verify(cR, never()).save(any(courseEntity.class));
    }
    @Test
    public void testSaveWithDuplicateNameAndCourseCode() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setName(name);
        courseEntity cE2 = new courseEntity();
        cE2.setName(name);
        cE2.setCoursesCode(coursesCode);


        when(cR.findOneBycoursesCode(coursesCode)).thenReturn(cE2);
        when(cR.findOneByName(name)).thenReturn(cE2);

        // When
        String result = courseService.save(coursedto);

        // Then
        assertEquals("Duplicate", result);
        verify(cR, times(1)).findOneBycoursesCode(coursesCode);
        verify(cR, times(1)).findOneByName(name);
        verify(cR, never()).save(any(courseEntity.class));
    }

    @Test
    public void testSaveSuccess() {
        // Given
        String coursesCode = "C123";
        String name = "Course 1";
        courseDTO coursedto = new courseDTO();
        coursedto.setCoursesCode(coursesCode);
        coursedto.setName(name);
        when(cR.findOneBycoursesCode(coursesCode)).thenReturn(null);
        when(cR.findOneByName(name)).thenReturn(null);

        courseEntity cE = new courseEntity();
        when(cC.toEntity(coursedto)).thenReturn(cE);

        // When
        String result = courseService.save(coursedto);

        // Then
        assertEquals("Success", result);
        verify(cR, times(1)).findOneBycoursesCode(coursesCode);
        verify(cR, times(1)).findOneByName(name);
        verify(cR, times(1)).save(cE);
    }
}
