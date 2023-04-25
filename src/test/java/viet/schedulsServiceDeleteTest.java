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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
	public class schedulsServiceDeleteTest {
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
	    public void testDelete() {
	        // Giả lập tham số đầu vào
	        int id = 123;

	        // Chạy phương thức cần kiểm tra
	        schedulesService.delete(id);

	        // Kiểm tra xem phương thức delete của courseRepository đã được gọi với đúng tham số id hay không
	        verify(sR, times(1)).delete(eq(id));
	    }
	   
	
	   
}
