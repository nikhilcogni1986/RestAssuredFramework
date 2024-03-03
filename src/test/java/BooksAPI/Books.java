package BooksAPI;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.datafaker.Faker;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Books {
    Faker faker = new Faker();
    private String name = faker.name().firstName();
    private String isbn = faker.name().lastName();
    private String aisle = faker.number().digits(4);
    private String author = faker.name().lastName();
}
