package viet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.viet.repository.courseRepository;
import com.viet.services.impl.courseService;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class courseServiceDeleteTest {
    @Mock
    private courseRepository cR;

    @InjectMocks
    private courseService courseService;

    @Test
    public void testDelete() {
        // Giả lập tham số đầu vào
        int id = 123;

        // Chạy phương thức cần kiểm tra
        courseService.delete(id);

        // Kiểm tra xem phương thức delete của courseRepository đã được gọi với đúng tham số id hay không
        verify(cR, times(1)).delete(eq(id));
    }
}
