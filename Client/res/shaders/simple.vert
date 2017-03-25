#version 330

layout (location = 0) in vec2 inVertexPosition;

void main()
{
	gl_Position = vec4(inVertexPosition.x, inVertexPosition.y, 0.0, 1.0);
}