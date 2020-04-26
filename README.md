# Android-txt

There's nothing much to explain here. The following is a basic example of how to perform IO operations to a `.txt` file.

Android provides very helpful libraries for doing so. We grab information from the `EditText` widget component and with the help of the `FileInputStream`, `InputStreamReader` and `OutputStreamWriter` classes with can write to a file and then read the content from it.

Data comes as bits Streams. And for that we need, to use Stream-related classes to transform that stream into readable text strings for IO manipulation. Check the `readFromFile()` and the `writeToFile()` methods for understanding the logic used.

## Credits

 - [David E Lares](https://twitter.com/davidlares3)

## License

 - [MIT](https://opensource.org/licenses/MIT)
