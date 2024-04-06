package com.example.jpa_example.service.book;

import com.example.jpa_example.constant.ResponseConstant;
import com.example.jpa_example.dto.GlobalResponseDTO;
import com.example.jpa_example.dto.book.request.BookSearchRequestDTO;
import com.example.jpa_example.dto.book.request.BookSaveRequestDTO;
import com.example.jpa_example.entity.BookEntity;
import com.example.jpa_example.repository.BookRepository;
import com.example.jpa_example.service.BaseCRUDService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookCRUDService implements BaseCRUDService<BookSaveRequestDTO, BookEntity, String, BookSearchRequestDTO> {
    final BookRepository bookRepository;

    public BookCRUDService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public GlobalResponseDTO<List<BookEntity>> getAll() {
        try{
            List<BookEntity> bookEntities = this.bookRepository.findAll();
            return new GlobalResponseDTO<>(
                    HttpStatus.OK.value(),
                    true,
                    ResponseConstant.SUCCESS,
                    bookEntities
            );
        }catch (Exception e) {
            return new GlobalResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    false,
                    e.getLocalizedMessage(),
                    null
            );
        }
    }

    @Override
    public GlobalResponseDTO<BookEntity> save(BookSaveRequestDTO saveRequest) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            BookEntity entity = objectMapper.convertValue(saveRequest, BookEntity.class);
            entity = this.bookRepository.save(entity);
            return new GlobalResponseDTO<>(
                    HttpStatus.OK.value(),
                    true,
                    ResponseConstant.SUCCESS,
                    entity
            );
        }catch (Exception e){
            return new GlobalResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    false,
                    e.getLocalizedMessage(),
                    null
            );
        }
    }

    @Override
    public GlobalResponseDTO<BookEntity> update(BookSaveRequestDTO updateRequest, String id) {
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            Optional<BookEntity> entity = this.bookRepository.findById(id);
            BookEntity updateEntity = objectMapper.convertValue(updateRequest, BookEntity.class);

            if (entity.isPresent())
                updateEntity.setUuid(entity.get().getUuid());
            else
                return new GlobalResponseDTO<>(HttpStatus.OK.value(), false, ResponseConstant.NOT_FOUND, null);

            updateEntity = this.bookRepository.save(updateEntity);
            updateEntity.setCreatedDate(entity.get().getCreatedDate());

            return new GlobalResponseDTO<>(
                    HttpStatus.OK.value(),
                    true,
                    ResponseConstant.SUCCESS,
                    updateEntity
            );
        }catch (Exception e){
            return new GlobalResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    false,
                    e.getLocalizedMessage(),
                    null
            );
        }
    }

    @Override
    public GlobalResponseDTO<Boolean> delete(String id) {
        try{
            Optional<BookEntity> entity = this.bookRepository.findById(id);

            if (entity.isPresent()) this.bookRepository.delete(entity.get());
            else
                return new GlobalResponseDTO<>(HttpStatus.OK.value(), false, ResponseConstant.NOT_FOUND, null);

            return new GlobalResponseDTO<>(
                    HttpStatus.OK.value(),
                    true,
                    ResponseConstant.SUCCESS,
                    Boolean.TRUE
            );
        }catch (Exception e) {
            return new GlobalResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    false,
                    e.getLocalizedMessage(),
                    null
            );
        }
    }

    @Override
    public GlobalResponseDTO<Page<BookEntity>> getAllBySizeAndPage(BookSearchRequestDTO bookSearchRequestDTO, Integer size, Integer page, String sortingBy, String sortingType) {
        try{
            Pageable pageable = PageRequest.of(
                    page,
                    size,
                    sortingType.equalsIgnoreCase("desc") ?
                            Sort.by(sortingBy).descending()
                            :
                            Sort.by(sortingBy).ascending()
            );
            return new GlobalResponseDTO<>(
                    HttpStatus.OK.value(),
                    true,
                    ResponseConstant.SUCCESS,
                    this.bookRepository.findByBookNameContains(
                            bookSearchRequestDTO.getSearchByBookName(),
                            pageable
                    )
            );
        }catch (Exception e) {
            return new GlobalResponseDTO<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    false,
                    e.getLocalizedMessage(),
                    null
            );
        }
    }
}
