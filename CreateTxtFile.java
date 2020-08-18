public String createFileListTxt(String path, String txtFileName)
{
	File file = new File(path);
	// This filter will only include files ending with .webm
	FilenameFilter fileFilter = new FilenameFilter() {
			@Override
			public boolean accept(File file, String name) {
				return name.endsWith(".webm");
			}
		};
		
	File[] fileNames = file.listFiles(fileFilter);
	
	if(fileNames != null && fileNames.length > 0)
	{
		try(FileWriter fw = new FileWriter(path + txtFileName))
		{
			fw.write("# audio file names of the candidate\n");
			for(File f : fileNames) {
				fw.write("file \'" + f.getAbsolutePath() + "\'\n");				
			}
			fw.close();
			System.out.println("Text file created");
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return "Error while writing txt file";
		}
	}
	else
		return "Directory has no audio files";
	return null;
}