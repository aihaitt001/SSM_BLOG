package springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc.mapper.ArtclesMapper;
import springmvc.model.Artcle;

@Service
public class ArtcleServiceImpt implements ArtcleService {

	@Autowired
	ArtclesMapper artclemapper;

	public int add(Artcle artcle) {
		// TODO Auto-generated method stub
		return artclemapper.add(artcle);
	}

	public void delete(Integer artcleId) {
		// TODO Auto-generated method stub
		artclemapper.delete(artcleId);
	}

	public List<Artcle> list() {
		// TODO Auto-generated method stub
		return artclemapper.list();
	}

	public Artcle getByArtcleId(Integer artcleId) {
		// TODO Auto-generated method stub
		return artclemapper.getByArtcleId(artcleId);
	}

	public void update(Artcle artcle) {
		// TODO Auto-generated method stub
		artclemapper.update(artcle);
	}

}
