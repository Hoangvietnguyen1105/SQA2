package viet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import com.viet.dto.schedulesDTO;
import com.viet.entity.scheduleEntity;
import com.viet.converter.courseConverter;
import com.viet.converter.scheduleConverter;
import com.viet.repository.courseRepository;
import com.viet.repository.schedulesRepository;
import com.viet.services.IschedulesService;
import com.viet.services.impl.schedulesService;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
	public class schedulsServiceSaveTest {
	//	
	//	private schedulesRepository sR;
	//	@Autowired
	//	private scheduleConverter sC;
	    @Mock
	    private schedulesRepository sR;
	    @Mock
	    private scheduleConverter sC;
	    @InjectMocks
	    private schedulesService schedulesService;
	
	    @Test
	    public void testSaveWithSuccess() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 12;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicateStart() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 12;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(start);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(12);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate6() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(9);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate7() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(16);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate2() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(14);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate3() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(start);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate4() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 14;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(13);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate5() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 14;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setStart(15);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate8() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 14;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(16);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate9() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(12);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	    @Test
	    public void testSaveWithDuplicate10() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setStart(11);
	    	entity.setLessonTime(2);
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	    	
	    	lst.add(entity);
	    	
	    	when(sR.findByDayAndRoom(day,room)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
	    	String result = schedulesService.save(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoom(day,room);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	    }
	  
	
	   
}
