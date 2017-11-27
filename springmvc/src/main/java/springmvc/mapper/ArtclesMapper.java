package springmvc.mapper;

import java.util.List;

import springmvc.model.Artcle;

public interface ArtclesMapper {

	public int add(Artcle artcle);

	public void delete(Integer artcleId);

	public List<Artcle> list();

	public Artcle getByArtcleId(Integer artcleId);

	public void update(Artcle artcle);
}
