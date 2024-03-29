/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.loadmodel.projector;

import com.occulue.api.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import com.occulue.repository.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Projector for NonConformLoadGroup as outlined for the CQRS pattern.
 *
 * <p>Commands are handled by NonConformLoadGroupAggregate
 *
 * @author your_name_here
 */
@Component("nonConformLoadGroup-entity-projector")
public class NonConformLoadGroupEntityProjector {

  // core constructor
  public NonConformLoadGroupEntityProjector(NonConformLoadGroupRepository repository) {
    this.repository = repository;
  }

  /*
   * Insert a NonConformLoadGroup
   *
   * @param	entity NonConformLoadGroup
   */
  public NonConformLoadGroup create(NonConformLoadGroup entity) {
    LOGGER.info("creating " + entity.toString());

    // ------------------------------------------
    // persist a new one
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Update a NonConformLoadGroup
   *
   * @param	entity NonConformLoadGroup
   */
  public NonConformLoadGroup update(NonConformLoadGroup entity) {
    LOGGER.info("updating " + entity.toString());

    // ------------------------------------------
    // save with an existing instance
    // ------------------------------------------
    return repository.save(entity);
  }

  /*
   * Delete a NonConformLoadGroup
   *
   * @param	id		UUID
   */
  public NonConformLoadGroup delete(UUID id) {
    LOGGER.info("deleting " + id.toString());

    // ------------------------------------------
    // locate the entity by the provided id
    // ------------------------------------------
    NonConformLoadGroup entity = repository.findById(id).get();

    // ------------------------------------------
    // delete what is discovered
    // ------------------------------------------
    repository.delete(entity);

    return entity;
  }

  /**
   * Method to retrieve the NonConformLoadGroup via an FindNonConformLoadGroupQuery
   *
   * @return query FindNonConformLoadGroupQuery
   */
  @SuppressWarnings("unused")
  public NonConformLoadGroup find(UUID id) {
    LOGGER.info("handling find using " + id.toString());
    try {
      return repository.findById(id).get();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find a NonConformLoadGroup - {0}", exc.getMessage());
    }
    return null;
  }

  /**
   * Method to retrieve a collection of all NonConformLoadGroups
   *
   * @param query FindAllNonConformLoadGroupQuery
   * @return List<NonConformLoadGroup>
   */
  @SuppressWarnings("unused")
  public List<NonConformLoadGroup> findAll(FindAllNonConformLoadGroupQuery query) {
    LOGGER.info("handling findAll using " + query.toString());
    try {
      return repository.findAll();
    } catch (IllegalArgumentException exc) {
      LOGGER.log(Level.WARNING, "Failed to find all NonConformLoadGroup - {0}", exc.getMessage());
    }
    return null;
  }

  // --------------------------------------------------
  // attributes
  // --------------------------------------------------
  @Autowired protected final NonConformLoadGroupRepository repository;

  private static final Logger LOGGER =
      Logger.getLogger(NonConformLoadGroupEntityProjector.class.getName());
}
