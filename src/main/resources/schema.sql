CREATE TABLE country (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name char(52),
    continent enum('Asia','Europe','North America','Africa','Oceania','Antarctica','South America'),
    region char(26),
    surface_area float(2),
    population int
);
