package design.pattern.visitor;

public interface Postable {
	void accept(Visitor visit);
}
