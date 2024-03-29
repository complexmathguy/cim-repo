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
package com.occulue.europeanstandards.commongridmodelexchangestandard.equipmentprofile.dc.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.controller.query.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity VsConverter.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/VsConverter")
public class VsConverterQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a VsConverter using a UUID
   *
   * @param UUID vsConverterId
   * @return VsConverter
   */
  @GetMapping("/load")
  public VsConverter load(@RequestParam(required = true) UUID vsConverterId) {
    VsConverter entity = null;

    try {
      entity =
          VsConverterBusinessDelegate.getVsConverterInstance()
              .getVsConverter(new VsConverterFetchOneSummary(vsConverterId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load VsConverter using Id " + vsConverterId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all VsConverter business objects
   *
   * @return Set<VsConverter>
   */
  @GetMapping("/")
  public List<VsConverter> loadAll() {
    List<VsConverter> vsConverterList = null;

    try {
      // load the VsConverter
      vsConverterList = VsConverterBusinessDelegate.getVsConverterInstance().getAllVsConverter();

      if (vsConverterList != null) LOGGER.log(Level.INFO, "successfully loaded all VsConverters");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all VsConverters ", exc);
      return null;
    }

    return vsConverterList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected VsConverter vsConverter = null;
  private static final Logger LOGGER =
      Logger.getLogger(VsConverterQueryRestController.class.getName());
}
