package TestData;

import api.payload.CreateTokenRequest;

public class GenerateTokenTestData {

	public CreateTokenRequest generateToken()
	{
		CreateTokenRequest createTokenRequest = new CreateTokenRequest();

		createTokenRequest.setUsername("admin");
		createTokenRequest.setPassword("password123");
				
		return createTokenRequest;
	}
}
