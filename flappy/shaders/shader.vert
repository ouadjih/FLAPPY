#version 330 core

void main(){
	const vec2 vertices[3] = vec2[3](
		vec2(0.5, 0.5),
		vec2(-0.5, -0.5),
		vec2(0.0, 0.5)
	);
	gl_Position = vertices[gl_Vertices[gl_VertexID], 0.5, 1.0);
}