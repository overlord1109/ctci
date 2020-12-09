import java.util.*;
import java.util.stream.Collectors;

public class BuildOrder {
	
	public static void main(String[] args) {
		Project a = new Project('a');
		Project b = new Project('b');
		Project c = new Project('c');
		Project d = new Project('d');
		Project e = new Project('e');
		Project f = new Project('f');
		Project g = new Project('g');
		List<Project> projects = Arrays.asList(a, b, c, d, e, f, g);
		List<Dependency> dependencies = Arrays.asList(new Dependency(a, e),	new Dependency(f, b), new Dependency(b, a), new Dependency(f, a), new Dependency(f, c), new Dependency(d, g), new Dependency(b, e));
		
		System.out.println("Projects ordered as: " + buildOrder(projects, dependencies).stream().map(project -> Character.toString(project.projectName)).collect(Collectors.joining(", ")));
	}
	
	static List<Project> buildOrder(List<Project> projects, List<Dependency> dependencies) {
		Map<Project, List<Project>> dependencyAdjacencyList = createAdjacencyList(projects, dependencies);
		Set<Project> visited = new HashSet<>();
		List<Project> orderedProjects = new ArrayList<>();
		
		System.out.println("Adjacency list created: ");
		printAdjList(dependencyAdjacencyList);
		System.out.println();
		
		for(Project project : projects)
			dfs(project, dependencyAdjacencyList, orderedProjects, visited);
		
		Collections.reverse(orderedProjects);
		
		return orderedProjects;
	}
	
	static void dfs(Project project, Map<Project, List<Project>> adjList, List<Project> orderedProjects, Set<Project> visited) {
		if(visited.contains(project))
			return;
		
		visited.add(project);
		List<Project> neighbours = adjList.get(project);
		
		for(Project neighbour : neighbours) {
			if(! visited.contains(neighbour))
				dfs(neighbour, adjList, orderedProjects, visited);
		}
		
		orderedProjects.add(project);
	}
	
	
	
	static Map<Project, List<Project>> createAdjacencyList(List<Project> projects, List<Dependency> dependencies) {
		Map<Project, List<Project>> adjList = new HashMap<>();
		for(Dependency dependency : dependencies) {
			if(!adjList.containsKey(dependency.start)) {
				List<Project> newList = new ArrayList<>();
				newList.add(dependency.end);
				adjList.put(dependency.start, newList);
			} else {
				List<Project> list = adjList.get(dependency.start);
				list.add(dependency.end);
			}
		}
		
		for(Project project : projects) {
			if(!adjList.containsKey(project))
				adjList.put(project, new ArrayList<Project>());
		}
		
		return adjList;
	}
	
	static void printAdjList(Map<Project, List<Project>> adjList) {
		for(Map.Entry<Project, List<Project>> entry : adjList.entrySet()) {
			System.out.print(entry.getKey().projectName + "->" + entry.getValue().stream().map(project -> Character.toString(project.projectName)).collect(Collectors.joining(", ")));
			System.out.println();
		}
	}
}

class Project {
	char projectName;
	
	Project(char projectName) {
		this.projectName = projectName;
	}
}

class Dependency {
	Project start;
	Project end;
	
	Dependency(Project start, Project end) {
		this.start = start;
		this.end = end;
	}
}