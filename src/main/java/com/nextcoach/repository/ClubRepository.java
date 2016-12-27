package com.nextcoach.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.nextcoach.domain.Club;

public interface ClubRepository extends PagingAndSortingRepository<Club, Long> {

	//
	// Page<City> findAll(Pageable pageable);
	//
	// Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String
	// name,
	// String country, Pageable pageable);
	//
	// City findByNameAndCountryAllIgnoringCase(String name, String country);
	// @Query("select h.city as city, h.name as name, avg(r.rating) as
	// averageRating "
	// + "from Hotel h left outer join h.reviews r where h.city = ?1 group by
	// h")
	// Page<HotelSummary> findByCity(City city, Pageable pageable);

}
