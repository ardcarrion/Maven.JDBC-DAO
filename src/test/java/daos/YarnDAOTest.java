package daos;

import models.YarnLabel;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class YarnDAOTest {
    private YarnDAO dao;

    @Test
    public void findById() {
        YarnLabel label = dao.findById(13);
        assertEquals("multi", label.getColor());
    }

    @Test
    public void findAll() {
        List<YarnLabel> labelList = dao.findAll();
        assertTrue(labelList.size() > 4);
    }

    @Test
    public void update() {
        YarnLabel label = dao.findById(11);
        label.setColor("crimson");
        dao.update(label);
        assertEquals("crimson", label.getColor());
    }

    @Test
    public void create() {
        dao.create(new YarnLabel("wool","mohair", YarnLabel.Ply.SINGLE, YarnLabel.Weight.SOCK, "blue"));
        YarnLabel label = dao.findById(19);
        assertNotNull(label);
        assertEquals("mohair", label.getSecondaryFiber());
    }

    @Test(expected = SQLException.class)
    public void delete() {
        //dao.delete(15);
        dao.findById(15);
    }

    @Before
    public void setUp() throws Exception {
        this.dao = new YarnDAO();
    }
}