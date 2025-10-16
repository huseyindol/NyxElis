-- init-schema.sql
-- hdcms şemasını oluştur (Eğer varsa hata vermesin diye IF NOT EXISTS ekledik)
CREATE SCHEMA IF NOT EXISTS hdcms AUTHORIZATION postgres;

-- Yeni oluşturulan veritabanı içinde bu şemayı varsayılan arama yolu yap
-- Bu, uygulamanızın hdcms.tablo_adı yerine doğrudan tablo_adı kullanabilmesini sağlar.
-- Ancak Java uygulamanız zaten schema adını JDBC URL'de kullanıyorsa bu satır opsiyoneldir.
-- ALTER DATABASE hdcms SET search_path TO hdcms, public;