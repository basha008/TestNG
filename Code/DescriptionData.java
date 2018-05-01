package resources;

public enum DescriptionData {

	DESCRIPTION_TEXT(
			"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed rutrum faucibus sem et posuere. Vivamus nec lectus quis sapien fringilla consequat. Aliquam pharetra posuere mollis. In ultrices felis ac facilisis pharetra. Duis ut libero massa. Morbi eu tortor porta, interdum arcu facilisis, lacinia nulla. Donec semper convallis nunc sit amet faucibus. Quisque sodales tortor eget magna ullamcorper, in porttitor nulla scelerisque. Sed porttitor porttitor neque, in euismod ligula euismod eu.\r\n"
					+ "\r\n"
					+ "In blandit malesuada hendrerit. Maecenas feugiat felis a tellus lobortis, ut hendrerit dui sollicitudin. Vestibulum mollis, metus ut eleifend dignissim, ipsum ligula molestie tellus, sed tempus nunc mi non dui. Mauris pellentesque lobortis convallis. Praesent iaculis imperdiet nibh, at facilisis erat malesuada eget. Nam ultricies nunc cursus tortor iaculis, vitae aliquam lorem dapibus. Etiam mattis feugiat nisl nec pretium. Phasellus maximus nisi ac justo porta, non rutrum est malesuada. Quisque at varius metus, eu auctor risus. Nunc ac ex accumsan, consectetur justo vitae, semper elit. Mauris justo lorem, pharetra at facilisis euismod, euismod sed nulla."), DESCRIPTION_LIST(
							"Lorem ipsum dolor sit amet, consectetur adipiscing elit.\r\n"
									+ "Duis viverra nisl et augue sagittis, ut ullamcorper dolor laoreet.\r\n"
									+ "Phasellus scelerisque mauris et nisl maximus luctus.\r\n"
									+ "Cras vitae quam quis orci dapibus efficitur.\r\n"
									+ "Phasellus sit amet arcu tincidunt, malesuada ante ac, consequat diam.\r\n"
									+ "Sed eleifend arcu a libero lacinia, suscipit pulvinar sem tempus.\r\n"
									+ "Mauris malesuada quam ac ante interdum ullamcorper.\r\n"
									+ "Nulla vel erat eget nunc euismod dapibus vel nec metus.\r\n"
									+ "Maecenas hendrerit quam in mi rhoncus, ut semper urna ultrices.\r\n"
									+ "Praesent molestie erat non imperdiet euismod.\r\n"
									+ "Aenean sed magna imperdiet, dapibus massa eu, laoreet nulla.\r\n"
									+ "Etiam eget neque nec sapien placerat ornare.\r\n"
									+ "Duis non erat ac nunc feugiat varius.\r\n"
									+ "Mauris venenatis lacus vitae eros mattis, id pellentesque libero elementum.\r\n"
									+ "Nulla semper mauris a nulla venenatis bibendum.\r\n"
									+ "Sed feugiat est eget nibh tincidunt, in auctor nulla condimentum.\r\n"
									+ "Mauris a libero sit amet augue mattis dictum.\r\n"
									+ "Duis tempor nisl a ante egestas rutrum.\r\n"
									+ "Etiam efficitur felis et elit pharetra tempor.");

	private String descriptionData;

	private DescriptionData(String descriptionData) {
		this.descriptionData = descriptionData;

	}

	public String getdescriptionData() {
		return descriptionData;
	}

}
