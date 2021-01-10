package objects;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class Person_UTest {

    public Person_UTest(){

    }

    @Before
    public void initialize()
    {

    }

    @Test
    public void t_getName() throws Exception{

        Person mock_p = Mockito.mock(Person.class);
        Mockito.when(mock_p.getName()).thenReturn(String.valueOf(Person.class.getDeclaredField("name")));

    }
}
