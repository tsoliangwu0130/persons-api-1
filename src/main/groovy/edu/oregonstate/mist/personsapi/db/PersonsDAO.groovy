package edu.oregonstate.mist.personsapi.db

import edu.oregonstate.mist.personsapi.core.JobObject
import edu.oregonstate.mist.personsapi.core.PersonObject
import edu.oregonstate.mist.personsapi.mapper.ImageMapper
import edu.oregonstate.mist.personsapi.mapper.JobsMapper
import edu.oregonstate.mist.personsapi.mapper.PersonMapper
import edu.oregonstate.mist.contrib.AbstractPersonsDAO
import org.skife.jdbi.v2.sqlobject.Bind
import org.skife.jdbi.v2.sqlobject.SqlQuery
import org.skife.jdbi.v2.sqlobject.customizers.Mapper

import java.sql.Blob

public interface PersonsDAO extends Closeable {
    @SqlQuery(AbstractPersonsDAO.personExist)
    String personExist(@Bind('osuID') String osuID)

    @SqlQuery(AbstractPersonsDAO.getPersons)
    @Mapper(PersonMapper)
    List<PersonObject> getPersons(@Bind('onid') onid, @Bind('osuID') osuID, @Bind('osuUID') osuUID)

    @SqlQuery(AbstractPersonsDAO.getPersonById)
    @Mapper(PersonMapper)
    PersonObject getPersonById(@Bind('osuID') String osuID)

    @SqlQuery(AbstractPersonsDAO.getJobsById)
    @Mapper(JobsMapper)
    List<JobObject> getJobsById(@Bind('osuID') String osuID)

    @SqlQuery(AbstractPersonsDAO.getImageById)
    @Mapper(ImageMapper)
    Blob getImageById(@Bind('osuID') String osuID)
}