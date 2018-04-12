package springmvc.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import springmvc.controller.ArticlesController;

public class GetArtcleByArtcleIdTest {

	@Test
	public void testGetArtcleByArtcleId() throws Exception {
		ArticlesController con = new ArticlesController();

		MockMvc mock = standaloneSetup(con).build();
		mock.perform(get("/artcles/1")).andExpect(view().name("artcle.html"));

	}

}
