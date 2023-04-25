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
import com.viet.entity.courseEntity;
import com.viet.entity.scheduleEntity;
import com.viet.converter.courseConverter;
import com.viet.converter.scheduleConverter;
import com.viet.repository.courseRepository;
import com.viet.repository.schedulesRepository;
import com.viet.services.IschedulesService;
import com.viet.services.impl.schedulesService;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
	public class schedulsServiceUpdateTest {
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
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay("3");
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(111);
	    	entity.setStart(6);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);

	    	when(sR.findOne(id)).thenReturn(entity);
	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(1)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithDuplicate1() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 12;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(13);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
//
//	    	when(sR.findOne(id)).thenReturn(entity);
//	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(0)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithDuplicate2() {
	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(12);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
//
//	    	when(sR.findOne(id)).thenReturn(entity);
//	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(0)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithDuplicate3() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(start);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
//
//	    	when(sR.findOne(id)).thenReturn(entity);
//	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(0)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithSuccess2() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(1);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst2);
//
	    	when(sR.findOne(id)).thenReturn(entity);
	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(1)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithDuplicate6() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(start);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
//
//	    	when(sR.findOne(id)).thenReturn(entity);
//	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(0)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithDuplicate7() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(12);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
//
//	    	when(sR.findOne(id)).thenReturn(entity);
//	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(0)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithDuplicate8() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(14);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
//
//	    	when(sR.findOne(id)).thenReturn(entity);
//	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Duplicated", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(0)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveSuccess3() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(13);
	    	entity.setRoom(room);
	    	entity.setStart(2);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst2);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
//
	    	when(sR.findOne(id)).thenReturn(entity);
	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(1)).save(any(scheduleEntity.class));

	    }
	    @Test
	    public void testSaveWithSucces4() {
	    	
	    	String day = "2";
	    	int room = 101;
	    	int coursesGroupId = 12;
	    	int start = 13;
	    	int lessonTime = 2;
	    	int id = 3;
	    	schedulesDTO dto = new schedulesDTO();
	    	dto.setDay(day);
	    	dto.setCoursesGroupId(coursesGroupId);
	    	dto.setRoom(room);
	    	dto.setStart(start);
	    	dto.setLessonTime(lessonTime);
	    	dto.setId(id);
	    	scheduleEntity entity = new scheduleEntity();
	    	entity.setDay(day);
	    	entity.setCoursesGroupId(12);
	    	entity.setRoom(room);
	    	entity.setStart(1);
	    	entity.setLessonTime(3);
	    	entity.setId(9);
	    	
	    	List<scheduleEntity> lst = new ArrayList<scheduleEntity>();
	    	List<scheduleEntity> lst2 = new ArrayList<scheduleEntity>();
	
	    	lst.add(entity);
	    	when(sR.findByDayAndRoomAndIdNot(day,room,id)).thenReturn(lst);
	    	when(sR.findBycoursesGroupIdAndDay(coursesGroupId,day)).thenReturn(lst);
//
	    	when(sR.findOne(id)).thenReturn(entity);
	    	when(sC.toEntity(dto,entity)).thenReturn(entity);


	    	String result = schedulesService.update(dto);
	    	assertEquals("Success", result);
	    	verify(sR, times(1)).findByDayAndRoomAndIdNot(day,room,id);
	      	verify(sR, times(1)).findBycoursesGroupIdAndDay(coursesGroupId,day);
	        verify(sR, times(1)).save(any(scheduleEntity.class));

	    }
	   
	  
	
	   
}
