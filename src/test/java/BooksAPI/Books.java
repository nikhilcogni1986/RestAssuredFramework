package BooksAPI;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Books
{
    private String name;
    private String isbn;
    private String aisle;
    private String author;
}
